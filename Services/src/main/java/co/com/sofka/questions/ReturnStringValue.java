package co.com.sofka.questions;

import io.restassured.response.ResponseBody;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ReturnStringValue implements Question<ResponseBody> {

    private final ResponseBody systemValue;

    private ReturnStringValue(ResponseBody systemValue) {
        this.systemValue = systemValue;
    }

    @Override
    public ResponseBody answeredBy(Actor actor) {
        return systemValue;
    }

    public static ReturnStringValue systemValue(ResponseBody systemValue){
        return new ReturnStringValue(systemValue);
    }

}
