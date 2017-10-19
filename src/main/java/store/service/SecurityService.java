package store.service;


public interface SecurityService {

    boolean accessCheck(String path, String role);
}
