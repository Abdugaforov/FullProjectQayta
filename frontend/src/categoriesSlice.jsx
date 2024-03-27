import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import apicall from './apicall/apicall.js';
const initialState = {
    categories: [],
    status: 'idle',
    error: null,
};

export const getCategoriesAsync = createAsyncThunk(
    'categories/getCategories',
    async (_, { rejectWithValue }) => {
        try {
            const response = await apicall("/category", "GET");
            return response.data;
        } catch (error) {
            return rejectWithValue(error.response.data);
        }
    }
);

export const saveCategoryAsync = createAsyncThunk(
    'categories/saveCategory',
    async (categoryData, { rejectWithValue }) => {
        try {
            const response = await apicall("/category", "POST", categoryData);
            return response.data;
        } catch (error) {
            return rejectWithValue(error.response.data);
        }
    }
);

const categoriesSlice = createSlice({
    name: 'categories',
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        // Fetch categories
        builder
            .addCase(getCategoriesAsync.pending, (state) => {
                state.status = 'loading';
            })
            .addCase(getCategoriesAsync.fulfilled, (state, action) => {
                state.status = 'succeeded';
                state.categories = action.payload;
            })
            .addCase(getCategoriesAsync.rejected, (state, action) => {
                state.status = 'failed';
                state.error = action.payload;
            });

        builder
            .addCase(saveCategoryAsync.pending, (state) => {
                state.status = 'loading';
            })
            .addCase(saveCategoryAsync.fulfilled, (state, action) => {
                state.status = 'succeeded';
                state.categories.push(action.payload);
            })
            .addCase(saveCategoryAsync.rejected, (state, action) => {
                state.status = 'failed';
                state.error = action.payload;
            });
    },
});

export default categoriesSlice.reducer;
