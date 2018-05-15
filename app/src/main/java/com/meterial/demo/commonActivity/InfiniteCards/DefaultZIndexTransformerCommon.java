package com.meterial.demo.commonActivity.InfiniteCards;


/**
 * @author BakerJ
 */
public class DefaultZIndexTransformerCommon implements ZIndexTransformer {
    @Override
    public void transformAnimation(CardItem card, float fraction, int cardWidth, int cardHeight, int fromPosition, int toPosition) {
        card.zIndex = 1f + 0.01f * fromPosition + 0.01f * (toPosition - fromPosition) * fraction;
    }

    @Override
    public void transformInterpolatedAnimation(CardItem card, float fraction, int cardWidth, int cardHeight, int fromPosition, int toPosition) {

    }
}