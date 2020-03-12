//--------------------------------------------------
// Class UploadImageResult
//--------------------------------------------------
// Written by Kenvix <i@kenvix.com>
//--------------------------------------------------

package com.kenvix.moecraftbot.ng.bot.provider.mirai.contact;

public class UploadImageResult {
    /**
     * imageId : {XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX}.jpg
     * url : xxxxxxxxxxxxxxxxxxxx
     */

    private String imageId;
    private String url;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
