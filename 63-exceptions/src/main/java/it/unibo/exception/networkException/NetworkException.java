package it.unibo.exception.networkException;

import java.io.IOException;
import java.util.Objects;

public class NetworkException  extends IOException{
    
    private static String DEFAULT_MESSAGE = "Network error: no response";


    public NetworkException(){
        super(DEFAULT_MESSAGE);
    }



    public NetworkException(final String messagge){
        super("Network error while sending message " + messagge);
        Objects.requireNonNull(messagge);
    }



}
