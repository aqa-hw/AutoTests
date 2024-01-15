package api.step;

import api.builders.BookBuilders;
import api.config.Requests;
import api.dto.request.book.DeleteBookDto;
import api.dto.response.book.BookDto;
import api.endpoints.BookEndpoint;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static api.config.RequestService.requestWithToken;
import static api.config.ResponseService.create;
import static api.config.ResponseService.delete;

public class BookSteps {

    Requests requests = new Requests();

    public BookDto addBookToUser() {
        return requests.post(requestWithToken(), new BookBuilders().defaultBookDtoBuilder(), BookEndpoint.ADD_BOOK.getBook())
                .then().spec(create()).extract().body().as(BookDto.class);
    }

public String deleteBookToUser() {
    Response response = requests
            .delete(requestWithToken(), BookEndpoint.DELETE_BOOK.deleteBook() + "c754adde-0dda-4856-b45d-cce96993989c");

    if (response.statusCode() == 204) {
        return "Success";
    } else {
        return "Failure";
    }
}
}

