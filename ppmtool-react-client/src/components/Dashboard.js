import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";
import Header from "./Layout/Header";
import CreateProjectButton from "./Project/CreateProjectButton";
import { getProjects } from "../actions/projectActions";
import PropTypes from "prop-types";
import { connect } from "react-redux";

class Dashboard extends Component {
  componentDidMount() {
    this.props.getProjects();
  }
  render() {
    return (
      <div className="projects">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Projects</h1>
              <br />
              <CreateProjectButton />
              <br />
              <hr />
            </div>
          </div>
        </div>
        <ProjectItem />
      </div>
    );
  }
}

Dashboard.propTypes = {
  project: PropTypes.object.isRequired,
  getProjects: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  project: state.project
});

export default connect(
  mapStateToProps,
  { getProjects }
)(Dashboard);
