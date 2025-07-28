
import React,{useEffect, useState} from 'react'
import { createDepartments, getDepartment, updateDepartment} from '../services/DepartmentService';
import { useNavigate, useParams } from 'react-router-dom';

const DepartmentComponent = () => {
    const [departmentName, setDepartmentName] = useState("")
    const [departmentDescription, setDepartmentDescription] = useState("")
    const navigate = useNavigate();
    const {id} = useParams();
    useEffect(()=>{
        getDepartment(id).then((response)=>
        {
            setDepartmentName(response.data.departmentName);
            setDepartmentDescription(response.data.departmentDescription);
        }).catch(error =>
        {
            console.error(error);
        }
        )

    },[id])
    

    function saveOrUpdateDepartment(e)
    {
        e.preventDefault()

        const departments = {departmentName, departmentDescription}
        console.log(departments);
        if(id){
             updateDepartment(id, departments).then((response)=>
        {
            console.log(response.data);
            navigate('/departments')
        }).catch(error =>
        {
            console.error(error);
        }
        )

        }else{

        createDepartments(departments).then((response)=>
        {
            console.log(response.data);
            navigate('/departments')
        }).catch(error =>
        {
            console.error(error);
        }
        )
    }

    }
     function PageTitle()
     {
        if(id){
            return <h2 text-center>Update Department</h2>
        }else{
            return <h2 text-center>Add Department</h2>
        }
     }
  return (
    <div className='container'>
        
        <div className='row'>
            <div className='card '>
              {
                PageTitle()
              }
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Department Name:</label>
                            <input
                                type='text'
                                placeholder='Enter Department First Name'
                                name='Department Name'
                                value={departmentName}
                                className={'form-control'}
                                onChange={(e) => setDepartmentName(e.target.value)}
                            >
                            </input>
                            
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Department Description:</label>
                            <input
                                type='text'
                                placeholder='Enter Department Description'
                                name='Department Description'
                                value={departmentDescription}
                                className={'form-control'}
                                onChange={(e) => setDepartmentDescription(e.target.value)}
                            >
                            </input>
                    
                        </div>

                        <button className='btn btn-success' onClick={saveOrUpdateDepartment} >Submit</button>

                        
                    </form>

                </div>
            </div>

        </div>

    </div>
  )
}



export default DepartmentComponent