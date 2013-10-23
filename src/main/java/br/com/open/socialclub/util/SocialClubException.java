/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.socialclub.util;

/**
 *
 * @author Felipe Silva
 */
public class SocialClubException extends Exception{

    public SocialClubException() {
    }

    public SocialClubException(String message) {
        super(message);
    }

    public SocialClubException(String message, Throwable cause) {
        super(message, cause);
    }

    public SocialClubException(Throwable cause) {
        super(cause);
    }
}
