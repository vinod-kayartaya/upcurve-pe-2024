# Create the following tables with the given structure

### REGIONS

<table>
    <thead>
        <tr>
            <th>Field name</th>
            <th>Data type</th>
            <th>Additional inputs</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>region_id</td>
            <td>int</td>
            <td>primary key</td>
        </tr>
        <tr>
            <td>region_name</td>
            <td>varchar(50)</td>
            <td>not null</td>
        </tr>
    </tbody>
</table>

### COUNTRIES

<table>
    <thead>
        <tr>
            <th>Field name</th>
            <th>Data type</th>
            <th>Additional inputs</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>country_id</td>
            <td>varchar(2)</td>
            <td>primary key</td>
        </tr>
        <tr>
            <td>country_name</td>
            <td>varchar(50)</td>
            <td>not null</td>
        </tr>
        <tr>
            <td>region_id</td>
            <td>int</td>
            <td>foreign key to REGIONS table</td>
        </tr>
    </tbody>
</table>

### LOCATIONS

<table>
    <thead>
        <tr>
            <th>Field name</th>
            <th>Data type</th>
            <th>Additional inputs</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>location_id</td>
            <td>int</td>
            <td>primary key</td>
        </tr>
        <tr>
            <td>street_address</td>
            <td>varchar(255)</td>
            <td></td>
        </tr>
        <tr>
            <td>postal_code</td>
            <td>varchar(10)</td>
            <td></td>
        </tr>
        <tr>
            <td>city</td>
            <td>varchar(50)</td>
            <td></td>
        </tr>
        <tr>
            <td>state_province</td>
            <td>varchar(50)</td>
            <td></td>
        </tr>
        <tr>
            <td>country_id</td>
            <td>varchar(2)</td>
            <td>foreign key to COUNTRIES table</td>
        </tr>
    </tbody>
</table>

### DEPARTMENTS

<table>
    <thead>
        <tr>
            <th>Field name</th>
            <th>Data type</th>
            <th>Additional inputs</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>department_id</td>
            <td>int</td>
            <td>primary key</td>
        </tr>
        <tr>
            <td>department_name</td>
            <td>varchar(50)</td>
            <td></td>
        </tr>
        <tr>
            <td>manager_id</td>
            <td>int</td>
            <td>foreign key to EMPLOYEES table</td>
        </tr>
        <tr>
            <td>location_id</td>
            <td>int</td>
            <td>foreign key to LOCATIONS table</td>
        </tr>
    </tbody>
</table>

### JOBS

<table>
    <thead>
        <tr>
            <th>Field name</th>
            <th>Data type</th>
            <th>Additional inputs</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>job_id</td>
            <td>varchar(15)</td>
            <td>primary key</td>
        </tr>
        <tr>
            <td>job_title</td>
            <td>varchar(50)</td>
            <td></td>
        </tr>
        <tr>
            <td>min_salary</td>
            <td>int</td>
            <td></td>
        </tr>
        <tr>
            <td>max_salary</td>
            <td>int</td>
            <td></td>
        </tr>
    </tbody>
</table>

### EMPLOYEES

<table>
    <thead>
        <tr>
            <th>Field name</th>
            <th>Data type</th>
            <th>Additional inputs</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>employee_id</td>
            <td>int</td>
            <td>primary key</td>
        </tr>
        <tr>
            <td>first_name</td>
            <td>varchar(50)</td>
            <td></td>
        </tr>
        <tr>
            <td>last_name</td>
            <td>varchar(50)</td>
            <td></td>
        </tr>
        <tr>
            <td>email</td>
            <td>varchar(100)</td>
            <td></td>
        </tr>
        <tr>
            <td>phone_number</td>
            <td>varchar(50)</td>
            <td></td>
        </tr>
        <tr>
            <td>hire_date</td>
            <td>date</td>
            <td></td>
        </tr>
        <tr>
            <td>job_id</td>
            <td>varchar(15)</td>
            <td>foreign key to JOBS table</td>
        </tr>
        <tr>
            <td>salary</td>
            <td>double</td>
            <td></td>
        </tr>
        <tr>
            <td>commission_pct</td>
            <td>double</td>
            <td></td>
        </tr>
        <tr>
            <td>manager_id</td>
            <td>int</td>
            <td>foreign key to EMPLOYEES table</td>
        </tr>
        <tr>
            <td>department_id</td>
            <td>int</td>
            <td>foreign key to DEPARTMENTS table</td>
        </tr>
    </tbody>
</table>

### JOB_HISTORY

<table>
    <thead>
        <tr>
            <th>Field name</th>
            <th>Data type</th>
            <th>Additional inputs</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>employee_id</td>
            <td>int</td>
            <td>composite key part 1</td>
        </tr>
        <tr>
            <td>start_date</td>
            <td>date</td>
            <td>composite key part 2</td>
        </tr>
        <tr>
            <td>end_date</td>
            <td>date</td>
            <td></td>
        </tr>
        <tr>
            <td>job_id</td>
            <td>varchar(15)</td>
            <td>foreign key to JOBS table</td>
        </tr>
        <tr>
            <td>department_id</td>
            <td>int</td>
            <td>foreign key to DEPARTMENTS table</td>
        </tr>
    </tbody>
</table>

### Values for the above tables are listed in the file - DATA_FOR_HR_TABLE.xlsx
