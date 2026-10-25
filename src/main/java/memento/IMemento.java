package memento;

import java.time.LocalDateTime;

public interface IMemento {
	LocalDateTime getCreatedAt(); // HISTORY WINDOW: date and time when the state was saved
}