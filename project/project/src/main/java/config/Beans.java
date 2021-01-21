@Configuration
public class Beans {
  @Bean
  public NodeService nodeService(final NodeRepository nodeRepository) {
    return new NodeServiceImpl(nodeRepository);
  }

  @Bean
  public DeviceService deviceService(final DeviceRepository deviceRepository,
      final NodeService nodeService) {
    return new DeviceServiceImpl(deviceRepository, nodeService);
  }

  @Bean
  public CommandService commandService(final CommandRepository commandRepository,
      final DeviceService deviceService) {
    return new CommandServiceImpl(deviceService, commandRepository);
  }

  @Bean
  public StateService stateService(final StateRepository stateRepository,
      final CommandService commandService) {
    return new StateServiceImpl(stateRepository, commandService);
  }}
