import { configureStore } from '@reduxjs/toolkit';
import productReducer from './productSlice .jsx';

export const store = configureStore({
    reducer: {
        product: productReducer,
    },
});
