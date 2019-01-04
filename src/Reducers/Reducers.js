const initialState = {data:{},photo:''};
export default function Reducers(state = initialState, action){

    switch(action.type){
        case 'ADD_DATA':
            return {...state,data:{...state.data,...action.text}}
        case 'ADD_PHOTO':
            return {...state,photo: action.text};
        case 'PERSONAL_STATE':
            return {...state,personalData: action.text};
        case 'ADD_USER_NAME':
            return {...state,user: action.text};
        case 'CLEAR_DATA':
            return {data:{},photo:'',user:''};
        default:{
            return state;
        }
    }
}