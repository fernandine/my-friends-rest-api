package digytal.myfriends.restapi.infra.exceptions;

public class RecordNotFoundException extends BusinessException {
	public RecordNotFoundException(Integer id) {
		super("001","Informe um ID Válido", "Não foi localizado um registro com o ID informado: %s ", id);
	}
}
