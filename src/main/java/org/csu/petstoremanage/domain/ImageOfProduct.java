package org.csu.petstoremanage.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Blob;

@Data
@TableName("imageofproduct")
public class ImageOfProduct
{
    @TableField("productId")
    private String productId;
    private byte[] image;

}
