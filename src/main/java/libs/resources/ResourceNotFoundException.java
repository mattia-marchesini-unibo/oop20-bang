package libs.resources;

public class ResourceNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 3520028846379020393L;

    public ResourceNotFoundException(String path) {
        super("resource " + path + " cannot be found");
    }
}
