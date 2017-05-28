package si.tim1.oglasi.viewmodels;

import si.tim1.oglasi.models.InappropriateAdvertReport;

/**
 * Created by Adnan on 5/11/2017.
 */
public class InappropriateAdvertReportVM {

    private Long id;
    private String message;
    private String prijavitelj;
    private String date;
    private Long advertId;
    private String username;
    private Boolean isGuest;

    public InappropriateAdvertReportVM() {}

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) { this.message = message; }

    public String getPrijavitelj() {
        return prijavitelj;
    }

    public void setPrijavitelj(String prijavitelj) {
        this.prijavitelj = prijavitelj;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Long advertId) {
        this.advertId = advertId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getIsGuest() {
        return isGuest;
    }

    public void setIsGuest(Boolean guest) {
        isGuest = guest;
    }

}
