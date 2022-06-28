package digytal.myfriends.restapi;

import digytal.myfriends.restapi.model.Friend;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


class FriendApplicationTests {
	@DisplayName("Testa a idade do Amigo com base no campo data nascimento com a data atual")
	@Test
	public void convertStringsToLocalDate(){
		LocalDate now = LocalDate.now();
		Friend cli = new Friend();

		cli.setBirthDate(LocalDate.of(1983,10,20));
		int expectation = Long.valueOf(ChronoUnit.YEARS.between(cli.getBirthDate(), now)).intValue();
		int result = cli.getAge();
		Assertions.assertEquals(expectation,result);

		cli.setBirthDate(LocalDate.of(1984,6,30));
		expectation = Long.valueOf(ChronoUnit.YEARS.between(cli.getBirthDate(), now)).intValue();
		result = cli.getAge();
		Assertions.assertEquals(expectation,result);
	}
}
