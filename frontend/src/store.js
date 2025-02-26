import { createStore } from 'vuex';
import createPersistedState from 'vuex-persistedstate';

const store = createStore({
  state() {
    return {
      username: '',
      role: '' // Add the new global variable here
    };
  },
  mutations: {
    setUsername(state, username) {
      state.username = username;
    },
    setRole(state, role) { // Add a mutation for the new global variable
      state.role = role;
    }
  },
  plugins: [createPersistedState()]
});

export default store;
