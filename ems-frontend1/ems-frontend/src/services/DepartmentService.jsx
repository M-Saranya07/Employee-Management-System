
import axios from "axios";

const Department_REST_API_BASE_URI = "http://localhost:8080/api/departments";

export const listDepartments = () => axios.get(Department_REST_API_BASE_URI);
export const createDepartments = (departments) => axios.post(Department_REST_API_BASE_URI, departments);
export const getDepartment = (departmentId) => axios.get(Department_REST_API_BASE_URI + '/' + departmentId);
export const updateDepartment = (departmentId, departments) => axios.put(Department_REST_API_BASE_URI + '/' + departmentId, departments);
export const deleteDepartment = (departmentId) => axios.delete(Department_REST_API_BASE_URI + '/' + departmentId);