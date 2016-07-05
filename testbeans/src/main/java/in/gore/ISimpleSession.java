package in.gore;

import javax.ejb.Local;

@Local
public interface ISimpleSession {
    public String getMessage();
}