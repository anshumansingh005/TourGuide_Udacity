package com.example.anshu.tourguide;

public class Location {

    /**
     * String resource ID for the default translation of the word
     */
    private int mDefaultTranslationId;

    /**
     * String resource ID for the Miwok translation of the word
     */
    private int mMiwokTranslationId;

    /**
     * Audio resource ID for the word
     */
    private String mAudioResourceId;

    /**
     * Image resource ID for the word
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    public Location(int defaultTranslationId, int miwokTranslationId, String audioResourceId) {
        mDefaultTranslationId = defaultTranslationId;
        mMiwokTranslationId = miwokTranslationId;
        mAudioResourceId = audioResourceId;
    }

    public Location(int defaultTranslationId, int miwokTranslationId, int imageResourceId,
                    String audioResourceId) {
        mDefaultTranslationId = defaultTranslationId;
        mMiwokTranslationId = miwokTranslationId;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public int getDefaultTranslationId() {
        return mDefaultTranslationId;
    }

    public int getMiwokTranslationId() {
        return mMiwokTranslationId;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Return the audio resource ID of the word.
     */
    public String getAudioResourceId() {
        return mAudioResourceId;
    }
}
