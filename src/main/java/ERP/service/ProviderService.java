package ERP.service;

import java.util.List;

import ERP.dto.ProviderDto;

public interface ProviderService {
	ProviderDto createProvider(ProviderDto provider);
	List<ProviderDto> getAllProvider();
	ProviderDto getProviderById(int id);
	ProviderDto modifyProvider(int id, ProviderDto provider);
	ProviderDto deleteProviderById(int id);

}