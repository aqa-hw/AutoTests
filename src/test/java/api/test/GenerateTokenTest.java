package api.test;

import api.step.BookSteps;
import api.step.UserSteps;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GenerateTokenTest {

    private final UserSteps steps = new UserSteps();
    private final BookSteps bookSteps = new BookSteps();

    @Test
    void generateToken() {

           bookSteps.addBookToUser();
           var responseUser = steps.getUser();
           bookSteps.deleteBookToUser();
           var responseUser1 = steps.getUser();


        Assertions.assertThat(responseUser.getBooks().get(0).getTitle()).isEqualTo("Git Pocket Guide");
        assertThat(responseUser1.getBooks()).isEmpty();


    }
}
