package funoscope.web.validator;

public interface SubscriptionValidator<T> {
    boolean validate(T pParams);
}
