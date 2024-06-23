package MODEL;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

public class SanPhamModel2 implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int itemID;
    private String itemName;
    private String description;
    private double price;
    private String brandName;
    private String author;
    private String image;  
    private Date date;
    private DateFormat df;
    private String content;
    
    

    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Icon getImageIcon() {
        return loadImageFromUrl(image);
    }

    public SanPhamModel2(int itemID, String itemName, String description, double price, String brandName, String image,String author,String content) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.brandName = brandName;
        this.image = image;
        this.author = author;
        this.content = content;
        
    }

    public SanPhamModel2() {
    }

    private Icon loadImageFromUrl(String imageUrl) {
        if (imageUrl == null || imageUrl.isEmpty()) {
            return null;
        }

        try {
            URL url = new URL(imageUrl);
            BufferedImage img = ImageIO.read(url);
            return new ImageIcon(img);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
