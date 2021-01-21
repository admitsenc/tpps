public final class ResponseService {
	  private ResponseService() {
	    //hide default constructor
	  }

	  public static ResponseEntity<ResponseItem> failed(final String message, final HttpStatus status) {
	    return new ResponseEntity<>(new ResponseItem(status.value(), message), status);
	  }

	  public static ResponseEntity<ResponseItem> success(final String message) {
	    return new ResponseEntity<>(new ResponseItem(HttpStatus.OK.value(), message), HttpStatus.OK);
	  }

	  public static <T> ResponseEntity<ResponseItem<T>> success(final String message, final T data) {
	    return new ResponseEntity<>(new ResponseItem<>(HttpStatus.OK.value(), message, data),
	        HttpStatus.OK);
	  }
	}
