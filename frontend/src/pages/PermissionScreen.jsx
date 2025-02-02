import React from "react";
import { Button } from "react-bootstrap";
import { Link } from "react-router-dom";
import "../../css/permission.css";

const PermissionScreen = () => {
  // Set document title dynamically
  document.title = "Permission";

  return (
    <div>
      <div className="cardBox">
        <Link to="/Dashboard" className="btn btn-primary">
          dashboard
        </Link>
        <div className="card">
          <div className="space">
            <Link to="/create-role" className="link">
              Create OR Assign
            </Link>
            <Link to="/assign-role" className="link">
              Assign role to user
            </Link>
            <Link to="/edit-role" className="link">
              Edit role name
            </Link>
            <Link to="/delete-role" className="link">
              Delete role
            </Link>
            <br />
          </div>
        </div>
      </div>
    </div>
  );
};

export default PermissionScreen;
