package mapper;

import javax.annotation.PostConstruct;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import dto.UserDto;
import dto.UserProfileDto;
import model.UserModel;
import model.UserProfile;


@Component
public class ModelMapperComponent {
	
	public static final ModelMapper modelMapper= new ModelMapper();
	
	@PostConstruct
	private void configureMapper() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        
        modelMapper.addMappings(
                new PropertyMap<UserModel, UserDto>() {
                    @Override
                    protected void configure() {
                    	map().setUserId(source.getUserId());
                    	map().setEmail(source.getEmail());
                    	map().setUserName(source.getUserName());
                    	map().setFirstName(source.getFirstName());
                    	map().setLastName(source.getLastName());
                    	when(Conditions.isNotNull()).using(ModelConverter.convertStatus).map(source.isStatus()).setStatus(null);
                    	map().getUserProfileDto().setId(source.getUserProfile().getId());
                    	map().getUserProfileDto().setAddress1(source.getUserProfile().getAddress1());
                    	map().getUserProfileDto().setAddress2(source.getUserProfile().getAddress2());
                    	map().getUserProfileDto().setCity(source.getUserProfile().getCity());
                    	map().getUserProfileDto().setCountry(source.getUserProfile().getCountry());
                    	using(ModelConverter.fromDateToString).map(source.getUserProfile().getDateOfBirth()).getUserProfileDto().setDateOfBirth(null);
                    	map().getUserProfileDto().setTelephone1(source.getUserProfile().getTelephone1());
                    	map().getUserProfileDto().setTelephone2(source.getUserProfile().getTelephone2());
                    	map().getUserProfileDto().setCity(source.getUserProfile().getCity());
                    	map().getUserProfileDto().setCountry(source.getUserProfile().getCountry());
                    	map().setPassword(null);
                    	map().setContacts(source.getContacts());
                    	//Lista de contatos tem erro porque o arg do arrayList (dto) é uma classe diferente do arg no arrayList (model)
                    }
                });
        
        modelMapper.addMappings(
                new PropertyMap<UserDto, UserModel>() {
                    @Override
                    protected void configure() {
                    	map().setUserId(source.getUserId());
                    	map().setPassword(source.getPassword());
                    	map().setEmail(source.getEmail());
                    	map().setUserName(source.getUserName());
                    	map().setFirstName(source.getFirstName());
                    	map().setLastName(source.getLastName());
                    	when(Conditions.isNotNull()).using(ModelConverter.convertStatusToBoolean).map(source.isStatus()).setStatus(false);
                    	skip().setUserProfile(null);
                    }
                });
        
        
        modelMapper.addMappings(
                new PropertyMap<UserProfileDto, UserProfile>() {
                    @Override
                    protected void configure() {
                    	map().setId(source.getId());
                    	map().setAddress1(source.getAddress1());
                    	map().setAddress2(source.getAddress2());
                    	map().setCity(source.getCity());
                    	map().setCountry(source.getCountry());
                    	using(ModelConverter.fromStringToDate).map(source.getDateOfBirth()).setDateOfBirth(null);
                    	map().setTelephone1(source.getTelephone1());
                    	map().setTelephone2(source.getTelephone2());
                    	map().setCountry(source.getCountry());
                    	map().setCity(source.getCity());
                    	skip().setUserModel(null); //Setando profile que vem do front e jogando pro back. Por que esse código da um skip na ligação com o UserModel? porque o arg é null?
                    	
                    }
                });
        
        modelMapper.addMappings(
                new PropertyMap<UserProfile, UserProfileDto>() {
                    @Override
                    protected void configure() {
                    	map().setId(source.getId());
                    	map().setAddress1(source.getAddress1());
                    	map().setAddress2(source.getAddress2());
                    	map().setCity(source.getCity());
                    	map().setCountry(source.getCountry());
                    	using(ModelConverter.fromDateToString).map(source.getDateOfBirth()).setDateOfBirth(null);
                    	map().setTelephone1(source.getTelephone1());
                    	map().setTelephone2(source.getTelephone2());
                    	map().setCity(source.getCity());
                    	map().setCountry(source.getCountry());
                    }
                });
	}
}