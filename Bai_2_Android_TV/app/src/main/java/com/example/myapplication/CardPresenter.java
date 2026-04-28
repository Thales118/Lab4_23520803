package com.example.myapplication;

import android.content.Context;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;

public class CardPresenter extends Presenter {
    private static int CARD_WIDTH = 313;
    private static int CARD_HEIGHT = 176;
    private static Context mContext;

    static class ViewHolder extends Presenter.ViewHolder {
        private ImageCardView mCardView;
        public ViewHolder(android.view.View view) {
            super(view);
            mCardView = (ImageCardView) view;
        }
        public ImageCardView getCardView() { return mCardView; }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        mContext = parent.getContext();
        ImageCardView cardView = new ImageCardView(mContext);
        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        Movie movie = (Movie) item;
        ViewHolder vh = (ViewHolder) viewHolder;
        vh.mCardView.setTitleText(movie.getTitle());
        vh.mCardView.setContentText(movie.getStudio());
        vh.mCardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
        Glide.with(mContext).load(movie.getCardImageUrl()).into(vh.mCardView.getMainImageView());
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        ((ViewHolder) viewHolder).mCardView.setMainImage(null);
    }
}