# propertiesSearch

propertiesSearch is a Java client that queries a publicly available API to provide
information about properties in the City of Philadelphia.

## Overview
### Quick Start

Currently, running propertiesSearch allows you search Philadelphia properties by
owner name. The results include owner name and address, providing a
"white pages" functionality.

Property value information is also available by uncommenting a single line of
source code, but is disabled by default.

### What This Is And Why I Wrote It

The current Web application provided by the City does not allow search by owner name.

Additionally, familiarity with the API allows you to perform useful analytics,
which I may explore in future versions.

### Current State Of The Program

Currently, the program supports console searching by user input and returns
a formatted table to the console. The number of results is limited and pre-set.

### Future Directions
Future versions may support CSV output, additional preset queries, arbitrary
queries, or a greater number or level of detail of results.

### Further Information
#### Wildcards
PostgreSQL wildcards are supported. `%` is a wildcard that matches any number
of characters. `_` is a wildcard that will match a single character.

Regardless, the beginning and end of the search string are treated as having
a `%` wildcard, so `Smith` matches `Smithson` or `Goldsmith`.

### Dependencies
The propertiesSearch source requires a Spring Boot 2.5.2 and JUnit 4.12
in order to compile.

## Legal
### License and Disclaimer of Warranty
This program is licensed under GPL v3.

However, I request as a courtesy that you do not distribute compiled binaries
outside of the developer community.

> This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
>
> This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
>
>You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
