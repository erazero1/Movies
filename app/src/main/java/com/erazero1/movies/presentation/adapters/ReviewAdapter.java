package com.erazero1.movies.presentation.adapters;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.erazero1.movies.R;
import com.erazero1.movies.model.reviews.Review;
import com.erazero1.movies.presentation.interfaces.OnReachEndListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private List<Review> reviewList = new ArrayList<>();
    private OnReachEndListener onReachEndListener;

    public void setOnReachEndListener(OnReachEndListener onReachEndListener) {
        this.onReachEndListener = onReachEndListener;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.review_item,
                        parent,
                        false
                );
        return new ReviewAdapter.ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Review review = reviewList.get(position);

        int backgroundId;

        if (Objects.equals(review.getType(), "Позитивный")) {
            backgroundId = R.color.holo_green_light;
        } else if (Objects.equals(review.getType(), "Негативный")) {
            backgroundId = R.color.holo_red_light;
        } else {
            backgroundId = R.color.holo_gray_light;
        }
        Drawable drawable = ContextCompat.getDrawable(holder.itemView.getContext(), backgroundId);
        holder.constraintLayoutFeedback.setBackground(drawable);

        holder.textViewUsername.setText(review.getAuthor());
        holder.textViewFeedback.setText(review.getReview());

        if (position >= reviewList.size() - 5 && onReachEndListener != null) {
            onReachEndListener.onReachEnd();
        }


    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    static class ReviewViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewUsername, textViewFeedback;
        private final ConstraintLayout constraintLayoutFeedback;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewFeedback = itemView.findViewById(R.id.textViewFeedback);
            textViewUsername = itemView.findViewById(R.id.textViewUsername);
            constraintLayoutFeedback = itemView.findViewById(R.id.constraintLayoutFeedback);
        }

    }
}

