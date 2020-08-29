package controller;

import view.LoginWindow;

import java.util.Random;

public class CaptchaController {
    private static CaptchaController ourInstance = new CaptchaController();

    public static CaptchaController getInstance() {
        return ourInstance;
    }

    private CaptchaController() {
    }

    public String getCaptcha(){
        char[] captcha = new char[5];
        Random random = new Random();
        for (int i = 0; i < 5; i++){
            captcha[i] = (char) ((char) random.nextInt(25)+65);
        }
        return String.valueOf(captcha);
    }

    public void checkCaptcha(String captcha, String input) throws CaptchaException{
        if (!captcha.equalsIgnoreCase(input))
            throw new CaptchaException("invalid code");
        else{
            LoginWindow window = new LoginWindow();
        }
    }
}
