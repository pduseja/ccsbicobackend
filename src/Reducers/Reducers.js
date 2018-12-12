const initialState = {data:{},photo:''};
export default function Reducers(state = initialState, action){
    switch(action.type){
        case 'ADD_DATA':
            return {...state,data:{...state.data,...action.text}}
        case 'ADD_PHOTO':
            return {...state,photo: action.text};
        case 'PERSONAL_STATE':
            return {...state,personalData: action.text};
        default:{
            return state;
        }
    }
}