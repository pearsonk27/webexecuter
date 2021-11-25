const React = require('react'); 
const ReactDOM = require('react-dom'); 
const client = require('./client'); 

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {tasks: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/tasks'}).done(response => {
			this.setState({tasks: response.entity._embedded.tasks});
		});
	}

	render() {
		return (
			<TaskTable tasks={this.state.tasks}/>
		)
	}
}

class TaskTable extends React.Component{
	render() {
		const tasks = this.props.tasks.map(task =>
			<Task key={task._links.self.href} task={task}/>
		);
		return (
			<table className="table table-hover">
				<thead>
					<tr>
						<th scope="col">Task Id</th>
						<th scope="col">Task Name</th>
						<th scope="col"></th>
						<th scope="col">Last Run</th>
						<th scope="col">Was Success</th>
						<th scope="col">Current Status</th>
					</tr>
				</thead>
				<tbody>
					{tasks}
				</tbody>
			</table>
		)
	}
}

class Task extends React.Component{
	render() {
        link = this.props.task._links.self.href
		id = link.substring(link.length - 1, link.length)
		wasSuccess = this.props.task.wasSuccess == true ? "Yes" : "No"
		return (
			<tr>
				<td scope="row">{id}</td>
                <td>{this.props.task.taskDisplayName}</td>
                <td><ExecuteButton task={this.props.task.taskName} /></td>
                <td>{this.props.task.formattedLastExecutionStartDateTime}</td>
                <td>{wasSuccess}</td>
                <td>{this.props.task.currentStatus}</td>
			</tr>
		)
	}
}

class ExecuteButton extends React.Component{

	handleClick = () => {
		// path = `/api/execute?name=${this.props.task}`
		// client({method: 'POST', path: path}).done(() => {});

		path = '/api/executionSchedules'
		body = {
			"task" : {
			  "name" : "test",
			  "displayName" : "Test"
			},
			"scheduleType" : {
			  "name" : "One Time",
			  "description" : "cron_expression is ignored when schedule_type is 'One Time'"
			},
			"startTime" : "2061-10-23T00:53:31.584-04:00",
			"active" : true
		}
		client({method: 'POST', path, body}).done(() => {})
	}

	render() {
		return (
			<button onClick={() => this.handleClick()}>
				Execute
			</button>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)