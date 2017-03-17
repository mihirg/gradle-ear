package in.gore;

import in.gore.entities.User;

import javax.ejb.Local;

@Local
public interface ISimpleSession {
    String getMessage();

    long createUser();

    User getUser();
}