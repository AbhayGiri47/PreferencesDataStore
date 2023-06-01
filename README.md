# PreferencesDataStore
Preferences DataStore
What is DataStore?
DataStore is a new and improved data storage solution aimed at replacing SharedPreferences. 
Built on Kotlin coroutines and Flow, DataStore provides two different implementations: **Proto DataStore,** that stores typed objects (backed by protocol buffers) and 
**Preferences DataStore,** that stores key-value pairs. 
Data is stored asynchronously, consistently, and transactionally, overcoming some of the drawbacks of SharedPreferences.

Preferences vs Proto DataStore
While both Preferences and Proto DataStore allow saving data, they do this in different ways:

**Preference DataStore**, like SharedPreferences, accesses data based on keys, without defining a schema upfront.
**Proto DataStore** defines the schema using Protocol buffers. Using Protobufs allows persisting strongly typed data. 
They are faster, smaller, simpler, and less ambiguous than XML and other similar data formats.
While Proto DataStore requires you to learn a new serialization mechanism, we believe that the strongly typed advantage brought by Proto DataStore is worth it.


Room vs DataStore
If you have a need for partial updates, referential integrity, or large/complex datasets, you should consider using Room instead of DataStore. 
DataStore is ideal for small or simple datasets and does not support partial updates or referential integrity.

Preferences DataStore API is similar to SharedPreferences with several notable differences:

Handles data updates transactionally
Exposes a Flow representing the current state of data
Does not have data persistent methods (apply(), commit())
Does not return mutable references to its internal state
Exposes an API similar to Map and MutableMap with typed keys

