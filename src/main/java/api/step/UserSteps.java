package api.step;

import api.config.Requests;

import api.dto.response.UserResponse;
import api.endpoints.Endpoints;
import api.utils.Utils;

public class UserSteps {

    Requests requests = new Requests();

    public UserResponse generateToken() {
          var request = requests.post(new UserBuilders().userDefaultBuilder(),
                Endpoints.GENERATE_TOKEN.getEndpoints()).body().asString();

          return Utils.fromJson(request, UserResponse.class);
    }
}
