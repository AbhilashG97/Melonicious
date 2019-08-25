package abhilash.example.com.melonicious.model;

public class Mentee {

    private String username;
    private String name;
    private String avatarURL;
    private String repositoriesURL;

    public Mentee(String username, String name, String avatarURL, String repositoriesURL) {
        this.username = username;
        this.name = name;
        this.avatarURL = avatarURL;
        this.repositoriesURL = repositoriesURL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getRepositoriesURL() {
        return repositoriesURL;
    }

    public void setRepositoriesURL(String repositoriesURL) {
        this.repositoriesURL = repositoriesURL;
    }

    @Override
    public String toString() {
        return "Mentee{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", avatarURL='" + avatarURL + '\'' +
                ", repositoriesURL='" + repositoriesURL + '\'' +
                '}';
    }
}
