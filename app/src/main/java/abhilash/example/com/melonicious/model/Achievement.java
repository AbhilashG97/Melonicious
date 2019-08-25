package abhilash.example.com.melonicious.model;

public class Achievement {
    private String achievementName;
    private int imageId;

    public Achievement(String achievementName, int imageId) {
        this.achievementName = achievementName;
        this.imageId = imageId;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "Achievement{" +
                "achievementName='" + achievementName + '\'' +
                ", imageId=" + imageId +
                '}';
    }
}
