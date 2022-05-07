package com.zp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    private String bName;

    private String bIsbn;

    private String bAuthor;

    private String bPublisher;

    private Float bPrice;

    private Integer btId;

    private Integer bStock;

    private String bMark;
    private boolean isScroll;
    private boolean isHot;
    private boolean isNew;

    public Books(String bName, String bIsbn, String bAuthor, String bPublisher, Float bPrice, Integer btId, Integer bStock, String bMark) {
        this.bName = bName;
        this.bIsbn = bIsbn;
        this.bAuthor = bAuthor;
        this.bPublisher = bPublisher;
        this.bPrice = bPrice;
        this.btId = btId;
        this.bStock = bStock;
        this.bMark = bMark;

    }
}
