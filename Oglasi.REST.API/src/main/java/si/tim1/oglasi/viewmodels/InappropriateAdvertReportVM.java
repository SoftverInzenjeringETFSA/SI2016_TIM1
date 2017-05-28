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

}
