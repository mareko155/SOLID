public class HttpRestRequest {

protected
    MuleMessage muleMessage;
protected
    Constraints validationConstraints;

public HttpRestRequest(MuleMessage muleMessage) {
        this.muleMessage = muleMessage;
    }

public void validate(Constraints validationConstraints) {
        this.validationConstraints = validationConstraints;
        processHeaders();

    }



    private void CheckIfHeaderRequired(String headerName, String HeaderValues) {
        if (headerValue == null && constraint.isHeaderRequired())
            {
                throw new InvalidHeaderException("Required header " + headerName + " not specified");
            }

    }



   private void SetHeaderValue(String headerName, String DefaultValue) {
        if (headerValue == null && constraint.getDefaultValue() != null)
            {
                muleMessage.setHeader(headerName, constraint.getDefaultValue());
            }
    }



    private void CheckIfFormatCorrect(String headerValue, Constraint constraint) {
        if (headerValue != null) {
            if (!constraint.validate(headerValue))
                {
                     throw new InvalidHeaderException(
                        MessageFormat.format("Invalid value format for header {0}.", headerName));
                }
        }
    }



   public void processHeaders()

    throws InvalidHeaderException{
            for (Constraint constraint : validationConstraints.getHeaderConstraints())
            {
                String headerName = constraint.getHeaderName();
                String headerValue = muleMessage.getHeader(headerName);

                CheckIfHeaderRequired(headerName, HeaderValues);
                SetHeaderValue(headerName, DefaultValue);
                CheckIfFormatCorrect(headerValue, constraint);
            }

      }

}
