package in.gore;

import javax.ejb.Stateless;

@Stateless
public class SimpleSessionBean implements ISimpleSession {
    public String getMessage() {
        return "Random String";
    }
}