package ke.vk.vinayak.kedge.footballleague.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class RestApiError {

  private HttpStatus status;
  private String message;

}
