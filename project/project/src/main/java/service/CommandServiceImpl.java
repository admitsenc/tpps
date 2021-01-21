package project;

public class CommandServiceImpl implements CommandService {
	  private static final Logger LOG = LoggerFactory.getLogger(CommandServiceImpl.class);
	  private final DeviceService deviceService;
	  private final CommandRepository commandRepository;

	  public CommandServiceImpl(final DeviceService deviceService,
	      final CommandRepository commandRepository) {
	    this.deviceService = deviceService;
	    this.commandRepository = commandRepository;
	  }

	  @Override
	  public List<Command> getCommandsByDeviceId(final String deviceId) {
	    Preconditions.checkNotNull(deviceId, "Device id can't be null");
	    LOG.debug("Get command by device id={}", deviceId);
	    return commandRepository.findAllByDeviceId(deviceId);
	  }

	  @Override
	  public Command getByIdAndUserId(final String id, final String userId) throws NoSuchItemException {
	    Preconditions.checkNotNull(userId, "User id can't be null");
	    Preconditions.checkNotNull(id, "Command id can't be null");
	    LOG.debug("Get command by id={}", id);

	    final Command command = commandRepository.findByIdAndUserId(id, userId);
	    if (command == null) {
	      throw new NoSuchItemException(String.format("Command with id=%s not found", id));
	    }
	    return command;
	  }

	  @Override
	  public List<Command> getAllByUserId(final String userId) {
	    Preconditions.checkNotNull(userId, "User id can't be null");

	    LOG.debug("Get all commands");
	    return commandRepository.findAllByUserId(userId);
	  }

	  @Override
	  public void add(final Command item, final String userId)
	      throws ItemAlreadyExistsException, NoSuchItemException {
	    Preconditions.checkNotNull(item, "User id can't be null");
	    Preconditions.checkNotNull(item, "Command can't be null");
	    Preconditions.checkNotNull(item.getDeviceId(), "Device id can't be null");
	    Preconditions.checkNotNull(item.getName(), "Command name can't be null");
	    Preconditions.checkNotNull(item.getPins(), "Command pins can't be null");

	    LOG.debug("Save command with name={} and pins={}", item.getName(), item.getPins());
	    deviceService.getByIdAndUserId(item.getDeviceId(), userId);

	    final Command command =
	        new Command(item.getName(), null, item.getPins(), item.getDeviceId(), item.getUserId());
	    commandRepository.save(command);
	  }

	  @Override
	  public void delete(final String id, final String userId) throws NoSuchItemException {
	    Preconditions.checkNotNull(id, "Command id can't be null");
	    LOG.debug("Delete command with id={}", id);
	    commandRepository.delete(getByIdAndUserId(id, userId));
	  }

	  @Override
	  public void update(final Command item, final String userId) throws NoSuchItemException {
	    Preconditions.checkNotNull(userId, "User id can't be null");
	    Preconditions.checkNotNull(item, "Command can't be null");
	    Preconditions.checkNotNull(item.getId(), "Command id can't be null");
	    Preconditions.checkNotNull(item.getDeviceId(), "Device id can't be null");
	    Preconditions.checkNotNull(item.getName(), "Command name can't be null");
	    Preconditions.checkNotNull(item.getPins(), "Command pins can't be null");

	    LOG.debug("Update command with id={}, name={} and pins={}", item.getId(), item.getName(),
	        item.getPins());
	    deviceService.getByIdAndUserId(item.getDeviceId(), userId);

	    final Command existsCommand = getByIdAndUserId(item.getId(), userId);
	    existsCommand.setCurrentState(item.getCurrentState());
	    existsCommand.setDeviceId(item.getDeviceId());
	    existsCommand.setName(item.getName());
	    existsCommand.setPins(item.getPins());

	    commandRepository.save(existsCommand);
	  }
	}
