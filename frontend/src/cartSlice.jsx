import { createSlice } from '@reduxjs/toolkit';

const initialState = {
    cart: [],
};

const cartSlice = createSlice({
    name: 'cart',
    initialState,
    reducers: {
        addToCart: (state, action) => {
            state.cart.push(action.payload);
        },
        removeFromCart: (state, action) => {
            state.cart = state.cart.filter(item => item.id !== action.payload);
        },
        updateCartItem: (state, action) => {
            const { id, productCount } = action.payload;
            const cartItem = state.cart.find(item => item.id === id);
            if (cartItem) {
                cartItem.productCount = productCount;
            }
        },
        clearCart: (state) => {
            state.cart = [];
        },
    },
});

export const { addToCart, removeFromCart, updateCartItem, clearCart } = cartSlice.actions;

export const selectCart = state => state.cart.cart;

export default cartSlice.reducer;
