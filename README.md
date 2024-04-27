# Expenses ingestor
This service produces a list of expenses by category to know how you are speding your money.

Functional Requirements:
The ingestor service should:
- Read expenses CSV files with a defined structure.
- Process records as incomes and outcomes.
- Set a category to each expense.
- Store the expenses with categories in a source to persist on time.
- Build final reports by categories and by amount.

Non-Functional Requirements:
- As the records would be huge, the processing should be done asynchronously.
- Use a database design which allows build the data from events.


Tech Stack:
- Scala
- Cats
- Cats-effect
- FS2

# Local development
To build the local image of the service
```
sbt apiService/Docker/publishLocal
```
