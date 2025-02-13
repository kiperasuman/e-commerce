package com.deneme.e_commerce.service.impl;

import com.deneme.e_commerce.dto.*;
import com.deneme.e_commerce.model.Cart;
import com.deneme.e_commerce.model.CartItem;
import com.deneme.e_commerce.model.Product;
import com.deneme.e_commerce.model.User;
import com.deneme.e_commerce.repository.CartItemRepository;
import com.deneme.e_commerce.repository.CartRepository;
import com.deneme.e_commerce.repository.ProductRepository;
import com.deneme.e_commerce.repository.UserRepository;
import com.deneme.e_commerce.service.ICartService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements ICartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public CartServiceImpl(CartRepository cartRepository,
                           UserRepository userRepository,
                           CartItemRepository cartItemRepository,
                           ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public DtoCart createCart(String username) {

        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Kullanıcı Bulunamadı.");
        } else {
            Cart cart = new Cart();
            cart.setUser(optionalUser.get());
            cartRepository.save(cart);
            DtoCart dtoCart = new DtoCart();
            dtoCart.setUserId(optionalUser.get().getId());
            dtoCart.setCartItems(new ArrayList<>());
            return dtoCart;

        }

    }

    @Override
    @Transactional
    public DtoCartItem addItemsToCart(AddToCartRequest addToCartRequest,String username){

       Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()){
            throw new RuntimeException("Kullanıcı Bulunamadı.");
        }


        Optional<Cart> optionalCart = cartRepository.findByUser(optionalUser.get());
        if (optionalCart.isEmpty()){
            Cart newCart = new Cart();
            cartRepository.save(newCart);
            DtoCartItem dto = new DtoCartItem();
            BeanUtils.copyProperties(newCart,dto);
            return dto;
        }

        Optional<Product> product = productRepository.findById(addToCartRequest.getProductId());
        if (product.isEmpty()){
            throw new RuntimeException("Ürün Bulunamadı.");
        }

        Optional<CartItem> isExistingCartItem =
                optionalCart.get().getCartItems()
                        .stream()
                        .filter(
                                cartItem -> cartItem.getProduct().getId()
                                        .equals(product.get().getId()))
                        .findFirst();
        CartItem cartItem;
        if (isExistingCartItem.isPresent()){
            cartItem  = isExistingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + addToCartRequest.getQuantity());
        }else {
            cartItem = new CartItem();
            cartItem.setCart(optionalCart.get());
            cartItem.setProduct(product.get());
            cartItem.setQuantity(addToCartRequest.getQuantity());
            cartItem.setPrice(product.get().getPrice());
            optionalCart.get().getCartItems().add(cartItem);
        }
        cartItem.setTotalPrice(product.get().getPrice());
        cartItemRepository.save(cartItem);
        cartRepository.save(optionalCart.get());

        DtoCartItem dtoCartItem = new DtoCartItem();
        dtoCartItem.setUnitPrice(product.get().getPrice());
        dtoCartItem.setProductId(product.get().getId());
        dtoCartItem.setQuantity(cartItem.getQuantity());
        dtoCartItem.setTotalPrice(cartItem.getTotalPrice());
        dtoCartItem.setCartId(optionalCart.get().getId());

        return dtoCartItem;

    }

    @Override
    public List<DtoCartItem> findAllCartItems(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()){
            throw new RuntimeException("Kullanıcı Bulunamadı.");
        }
        Optional<Cart> cart = cartRepository.findByUser(user.get());
        if (cart.isEmpty()){
            throw new RuntimeException("Sepet Bulunamadı.");
        }
        List<CartItem> cartItems = cart.get().getCartItems();
        if (cartItems.isEmpty()){
            throw new RuntimeException("Sepetinizde Ürün Bulunamadı.");
        }
        List<CartItem> allCartItem = cartItemRepository.findAll();
        List<DtoCartItem> dtoCartItems = new ArrayList<>();
        for (CartItem cartItem : allCartItem){
            DtoCartItem dtoCartItem = new DtoCartItem();
            dtoCartItem.setCartId(cartItem.getCart().getId());
            dtoCartItem.setUnitPrice(cartItem.getPrice());
            dtoCartItem.setQuantity(cartItem.getQuantity());
            dtoCartItem.setTotalPrice(cartItem.getTotalPrice());
            dtoCartItem.setProductId(cartItem.getId());
            dtoCartItem.setProductName(cartItem.getProduct().getName());
            dtoCartItem.setCategoryName(cartItem.getProduct().getCategory().getName());
            dtoCartItems.add(dtoCartItem);
        }
        return dtoCartItems;
    }

    @Override
    @Transactional
    public DtoCartItem updateCartItem(AddToCartRequest addToCartRequest, String username) {

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()){
            throw new RuntimeException("Kullanıcı Bulunamadı.");
        }

        Optional<Cart> userCart = cartRepository.findByUser(user.get());
        if (userCart.isEmpty()){
            throw new RuntimeException("Sepet Bulunamadı.");
        }
        // Liste halinde tüm sepet içeriğini alır. ve id ye göre ilgili olanı getirir.
        Optional<CartItem> cartItems = userCart.get().getCartItems()
                .stream()
                .filter(cartItem ->
                        cartItem.getProduct().getId().equals(addToCartRequest.getProductId()))
                .findFirst();

        if (cartItems.isEmpty()){
            throw new RuntimeException("Ürün Sepette Bulunamadı.");
        }

        CartItem cartItem = cartItems.get();
        if (addToCartRequest.getQuantity()<=0){
            userCart.get().getCartItems().remove(cartItem);
            cartItemRepository.delete(cartItem);
        }else{
            cartItem.setQuantity(addToCartRequest.getQuantity());
            cartItem.setTotalPrice(cartItem.getPrice());
            cartItemRepository.save(cartItem);
        }
        DtoCartItem dtoCartItem = new DtoCartItem();
        dtoCartItem.setCartId(userCart.get().getId());
        dtoCartItem.setCategoryName(cartItem.getProduct().getCategory().getName());
        dtoCartItem.setTotalPrice(cartItem.getTotalPrice());
        dtoCartItem.setQuantity(cartItem.getQuantity());
        dtoCartItem.setProductName(cartItem.getProduct().getName());
        dtoCartItem.setUnitPrice(cartItem.getPrice());
        dtoCartItem.setProductId(cartItem.getProduct().getId());

        return dtoCartItem;
    }

    @Override
    public void removeCartItem(Long productId, String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()){
            throw new RuntimeException("Kullanıcı Bulunamadı.");
        }

        Optional<Cart> userCart = cartRepository.findByUser(user.get());
        if (userCart.isEmpty()){
            throw new RuntimeException("Sepet Bulunamadı.");
        }
        Cart cart = userCart.get();
        List<CartItem> cartItems = cart.getCartItems();
        if (cartItems.isEmpty()){
            throw new RuntimeException("Ürün Bulunamadı");
        }
        Optional<CartItem> optionalCartItem = cartItems.stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst();
        if (optionalCartItem.isEmpty()) {
            throw new RuntimeException("Sepette bu ürün bulunamadı.");
        }
        CartItem cartItem = optionalCartItem.get();
        cartItems.remove(cartItem);
        cartItemRepository.delete(cartItem);


    }


}
