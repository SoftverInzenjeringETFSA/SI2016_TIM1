package si.tim1.oglasi.viewmodels;

import si.tim1.oglasi.models.InappropriateAdvertReport;

/**
 * Created by Adnan on 5/11/2017.
 */
public class InappropriateAdvertReportVM {

    private String message;

    public InappropriateAdvertReportVM() {}

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) { this.message = message; }
}
